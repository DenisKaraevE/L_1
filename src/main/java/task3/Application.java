package task3;

interface Button {
    void render();
    void onClick();
}
interface Checkbox {
    void render();
    Checkbox state(boolean state);
    boolean state();
}
interface Input {
    void render();
    Input value(String value);
    String value();
}
interface FormElementFactory {
    Button createButton();
    Checkbox createCheckbox();
    Input createInput();
}

class WebButton implements Button {
    public void render() {
        System.out.println("render WebButton");
    }

    public void onClick() {
        System.out.println("Event on click WebButton");
    }
}
class WebCheckbox implements Checkbox {

    private boolean state;

    public void render() {
        System.out.println(
                String.format("render WebCheckbox. With state %s", state)
        );
    }

    public boolean state() {
        return state;
    }

    public Checkbox state(boolean state) {
        this.state = state;
        return this;
    }

}
class WebInput implements Input {

    private String value;

    public Input value(String value) {
        this.value = value;
        return this;
    }

    public String value() {
        return value;
    }

    public void render() {
        System.out.println(
                String.format("render WebInput. With value %s", value)
        );
    }

}
class WebFormElementFactory implements FormElementFactory {

    public Button createButton() {
        return new WebButton();
    }

    public Checkbox createCheckbox() {
        return new WebCheckbox();
    }

    public Input createInput() {
        return new WebInput();
    }

}

class MobButton implements Button {
    public void render() {
        System.out.println("render MobButton");
    }

    public void onClick() {
        System.out.println("Event on click MobButton");
    }
}
class MobCheckbox implements Checkbox {

    private boolean state;

    public void render() {
        System.out.println(
                String.format("render MobCheckbox. With state %s", state)
        );
    }

    public boolean state() {
        return state;
    }

    public Checkbox state(boolean state) {
        this.state = state;
        return this;
    }

}
class MobInput implements Input {

    private String value;

    public Input value(String value) {
        this.value = value;
        return this;
    }

    public String value() {
        return value;
    }

    public void render() {
        System.out.println(
                String.format("render MobInput. With value %s", value)
        );
    }

}
class MobFormElementFactory implements FormElementFactory {

    public Button createButton() {
        return new MobButton();
    }

    public Checkbox createCheckbox() {
        return new MobCheckbox();
    }

    public Input createInput() {
        return new MobInput();
    }

}

class Configuration {

    public final static int WEB = 1;
    public final static int MOB = 2;

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

class AbstractFabricService extends Configuration {

    private FormElementFactory initFactory() {
        Configuration configuration = Configuration.initWeb();

        FormElementFactory factory;
        switch (configuration.getPlaform()) {
            case (WEB):
                factory = new WebFormElementFactory();
                break;
            case (MOB):
                factory = new MobFormElementFactory();
                break;
            default:
                try {
                    throw new Exception("Неизвестный тип платформы");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
        return factory;
    }


    private void renderForm(FormElementFactory factory) {
        Input input = factory.createInput();
        Button button = factory.createButton();

        input.value("Тестовое значение поля ввода данных");
        input.render();
        button.render();
    }

    public void exec() {
        renderForm(
                initFactory()
        );
    }
}

class Application {

    public static void main(String[] args) {
        AbstractFabricService service = new AbstractFabricService();
        service.exec();
    }

}


