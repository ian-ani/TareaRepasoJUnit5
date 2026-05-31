package es.iesmz.entity;

import java.util.Objects;

public class Time {
    /* ATRIBUTOS */

    private int hour;
    private int minute;
    private int second;

    /* CONSTRUCTOR */

    public Time(int hour, int minute, int second) throws Exception {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    /* GETTERS */

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    /* SETTERS */

    public void setHour(int hour) throws Exception {
        if (hour < 0 || hour > 23) {
            throw new Exception("Valor de hora no válido.");
        }

        this.hour = hour;
    }

    public void setMinute(int minute) throws Exception {
        if (minute < 0 || minute > 59) {
            throw new Exception("Valor de minuto no válido.");
        }

        this.minute = minute;
    }

    public void setSecond(int second) throws Exception {
        if (second < 0 || second > 59) {
            throw new Exception("Valor de segundo no válido.");
        }

        this.second = second;
    }

    public void setTime(int hour, int minute, int second) throws Exception {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    /* METODO TOSTRING */

    @Override
    public String toString() {
        // [hh:mm:ss]
        return String.format("%02d:%02d:%02d\n", hour, minute, second);
    }

    /* METODO EQUALS Y HASHCODE */

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Time time)) return false;
        return hour == time.hour && minute == time.minute && second == time.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }

    /* OTROS METODOS */

    public Time nextSecond() {
        if (this.second < 59) {
            this.second++;
        } else {
            this.second = 0;
            if (this.minute < 59) {
                this.minute++;
            } else {
                this.minute = 0;
                if (this.hour < 23) {
                    this.hour++;
                } else {
                    this.hour = 0;
                }
            }
        }

        return this;
    }
}
