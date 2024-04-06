/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

public class UNOCard {
    private final String color;
    private final String value;

    public UNOCard(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public boolean canBePlayedOn(UNOCard other) {
        return this.color.equals(other.color) || this.value.equals(other.value);
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}