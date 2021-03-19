package by.it.kglushchenko.jd01_08.oop;

public interface ILightsource {
    /*
     * Base methods Sources of Light
     */

    boolean isSwitched();   // Метод возвращает - выключен или включен
    void SwitchOn();        // Включить источник
    void SwitchOff();       // Выключить источник
    double SetBrightness(); // Установить яркость
    double GetBrightness(); // Вернуть значение - яркость

}
