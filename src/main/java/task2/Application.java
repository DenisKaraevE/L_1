package task2;

interface Button {
    void render();
}
interface Dialog {
    void render();
}
class WebButton implements Button {
    public void render() {
        System.out.println("render WebButton");
    }
}
class MobButton implement Button {
    public void render() {
        System.out.println("render MobButton");
    }
}
abstarct class AbstractDialog implements Dialog {

    // Фабричный метод
    abstarct Button getButton();

    public void render() {
        Button button = getButton();
        button.render();
    }

}
class WebDialog implements AbstractDialog {
    private Button getButton() {
        return new WebButton();
    }
}
class MobDialog extends AbstractDialog {
    private Button getButton() {
        return new MobButton();
    }
}

class Configuration {

    public final static String int WEB = 1;
    public final static String int MOB = 2;

    private int platform;

    public int getPlaform() {
        return platform;
    }

    public Configuration setPlatform(int platform) {
        this.platform = platform;
        return this;
    }

    public static Configuration initWeb() {
        return new Configuration().setPlatform(WEB);
    }

    public static Configuration initMob() {
        return new Configuration().setPlatform(MOB);
    }

}


class FabricMethodService {

    public void exec() {
        Configuration configuration = Configuration.initWeb();

        Dialog dialog;
        switch(conf.getPlatform()) {
            case (WEB):
                dialog = new WebDialog();
            case (MOB):
                dialog = new MobDialog();
            default:
                throw new Exeption("Не известный тип платформы");
        }

        dialog.render();
    }

}

class Application {

    public static void main(String[] args) {
        FabricMethodService service = new FabricMethodService();
        service.exec();
    }

}
