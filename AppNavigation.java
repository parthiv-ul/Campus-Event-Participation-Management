import javax.swing.JFrame;

final class AppNavigation {

    private AppNavigation() {
    }

    static void open(JFrame nextFrame, JFrame currentFrame) {
        nextFrame.setVisible(true);
        currentFrame.dispose();
    }

    static void returnToDashboard(JFrame currentFrame) {
        open(new DashboardFrame(), currentFrame);
    }
}
