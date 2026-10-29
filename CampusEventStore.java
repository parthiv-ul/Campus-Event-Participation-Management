import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class CampusEventStore {

    private static final Map<String, Event> EVENTS = new LinkedHashMap<>();
    private static final Map<String, Participant> PARTICIPANTS = new LinkedHashMap<>();
    private static final Map<String, Registration> REGISTRATIONS = new LinkedHashMap<>();
    private static final Map<String, Attendance> ATTENDANCE = new LinkedHashMap<>();

    private CampusEventStore() {
    }

    static final class Event {
        final String id;
        final String name;
        final String type;
        final String date;
        final String time;
        final String venue;
        final int capacity;
        final String description;

        Event(String id, String name, String type, String date, String time,
                String venue, int capacity, String description) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.date = date;
            this.time = time;
            this.venue = venue;
            this.capacity = capacity;
            this.description = description;
        }
    }

    static final class Participant {
        final String participantId;
        final String studentId;
        final String studentName;
        final String eventId;
        final String eventName;
        final String eventType;
        final String registrationStatus;

        Participant(String participantId, String studentId, String studentName,
                String eventId, String eventName, String eventType,
                String registrationStatus) {
            this.participantId = participantId;
            this.studentId = studentId;
            this.studentName = studentName;
            this.eventId = eventId;
            this.eventName = eventName;
            this.eventType = eventType;
            this.registrationStatus = registrationStatus;
        }
    }

    static final class Registration {
        final String studentId;
        final String studentName;
        final String eventId;
        final String eventName;
        final String eventType;

        Registration(String studentId, String studentName, Event event) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.eventId = event.id;
            this.eventName = event.name;
            this.eventType = event.type;
        }
    }

    static final class Attendance {
        final String studentId;
        final String studentName;
        final String eventId;
        final String eventName;
        final String status;
        final String date;

        Attendance(String studentId, String studentName, String eventId,
                String eventName, String status, String date) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.eventId = eventId;
            this.eventName = eventName;
            this.status = status;
            this.date = date;
        }
    }

    static synchronized void saveEvent(Event event) {
        requireText(event.id, "Event ID");
        if (EVENTS.containsKey(key(event.id))) {
            throw new IllegalArgumentException("An event with this ID already exists.");
        }
        EVENTS.put(key(event.id), event);
    }

    static synchronized void updateEvent(Event event) {
        requireText(event.id, "Event ID");
        if (!EVENTS.containsKey(key(event.id))) {
            throw new IllegalArgumentException("No event exists with this ID.");
        }
        EVENTS.put(key(event.id), event);
    }

    static synchronized void deleteEvent(String eventId) {
        requireText(eventId, "Event ID");
        String id = key(eventId);
        if (EVENTS.remove(id) == null) {
            throw new IllegalArgumentException("No event exists with this ID.");
        }
        PARTICIPANTS.values().removeIf(participant -> key(participant.eventId).equals(id));
        REGISTRATIONS.values().removeIf(registration -> key(registration.eventId).equals(id));
        ATTENDANCE.values().removeIf(attendance -> key(attendance.eventId).equals(id));
    }

    static synchronized Event findEvent(String eventId) {
        return EVENTS.get(key(eventId));
    }

    static synchronized Event findEvent(String searchBy, String value) {
        String query = key(value);
        if ("Event ID".equals(searchBy)) {
            return EVENTS.get(query);
        }
        for (Event event : EVENTS.values()) {
            String candidate = "Event Name".equals(searchBy) ? event.name : event.type;
            if (key(candidate).contains(query)) {
                return event;
            }
        }
        return null;
    }

    static synchronized List<String> getEventIds() {
        List<String> ids = new ArrayList<>();
        for (Event event : EVENTS.values()) {
            ids.add(event.id);
        }
        return ids;
    }

    static synchronized void saveParticipant(Participant participant) {
        requireText(participant.participantId, "Participant ID");
        requireText(participant.studentId, "Student ID");
        requireText(participant.studentName, "Student Name");
        requireEvent(participant.eventId);
        String id = key(participant.participantId);
        if (PARTICIPANTS.containsKey(id)) {
            throw new IllegalArgumentException("A participant with this ID already exists.");
        }
        PARTICIPANTS.put(id, participant);
    }

    static synchronized void register(String studentId, String studentName, String eventId) {
        requireText(studentId, "Student ID");
        requireText(studentName, "Student Name");
        Event event = requireEvent(eventId);
        String id = registrationKey(studentId, event.id);
        if (REGISTRATIONS.containsKey(id)) {
            throw new IllegalArgumentException("This student is already registered for the event.");
        }
        long registered = REGISTRATIONS.values().stream()
                .filter(registration -> key(registration.eventId).equals(key(event.id)))
                .count();
        if (registered >= event.capacity) {
            throw new IllegalArgumentException("This event has reached its participant limit.");
        }
        REGISTRATIONS.put(id, new Registration(studentId.trim(), studentName.trim(), event));
    }

    static synchronized void markAttendance(String studentId, String studentName,
            String eventId, String eventName, String status, String date) {
        requireText(studentId, "Student ID");
        requireText(studentName, "Student Name");
        requireText(eventId, "Event ID");
        requireText(eventName, "Event Name");
        requireText(date, "Date");
        String id = registrationKey(studentId, eventId);
        ATTENDANCE.put(id, new Attendance(studentId.trim(), studentName.trim(),
                eventId.trim(), eventName.trim(), status, date.trim()));
    }

    static synchronized int getRegistrationCount(String eventId) {
        return (int) REGISTRATIONS.values().stream()
                .filter(registration -> eventId == null
                        || key(registration.eventId).equals(key(eventId)))
                .count();
    }

    static synchronized int getParticipantCount() {
        return PARTICIPANTS.size();
    }

    static synchronized int getParticipantCount(String eventId) {
        return (int) PARTICIPANTS.values().stream()
                .filter(participant -> eventId == null
                        || key(participant.eventId).equals(key(eventId)))
                .count();
    }

    static synchronized int getAttendanceCount(String eventId, String status) {
        return (int) ATTENDANCE.values().stream()
                .filter(attendance -> (eventId == null
                        || key(attendance.eventId).equals(key(eventId)))
                        && attendance.status.equalsIgnoreCase(status))
                .count();
    }

    private static Event requireEvent(String eventId) {
        requireText(eventId, "Event ID");
        Event event = EVENTS.get(key(eventId));
        if (event == null) {
            throw new IllegalArgumentException("Create the event before using its ID.");
        }
        return event;
    }

    private static void requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required.");
        }
    }

    private static String registrationKey(String studentId, String eventId) {
        return key(studentId) + "\u0000" + key(eventId);
    }

    private static String key(String value) {
        return value == null ? "" : value.trim().toLowerCase();
    }
}
