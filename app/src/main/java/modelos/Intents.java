package modelos;

import android.content.Intent;

public class Intents
{
    private String name;
    private Intent action;

    public Intents(String name, Intent action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getAction() {
        return action;
    }

    public void setAction(Intent action) {
        this.action = action;
    }
}