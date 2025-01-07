#include <iostream>


class Clock{
    protected:
        int _hours;
        int _minutes;
        int _seconds;

    public:
        Clock(int hours, int minutes, int seconds);

        virtual ~Clock() {}

        void tic();
        void print();
};