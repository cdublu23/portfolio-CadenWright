#include "clock.h"
#include <iomanip>
#include <iostream>

Clock::Clock(int hours, int minutes, int seconds)
     : _hours{hours}, _minutes{minutes}, _seconds{seconds}{
        if(hours > 23 || hours < 0) throw std::out_of_range("Hours out of range (0-23): " + hours);
        if(minutes > 59 || minutes < 0) throw std::out_of_range("Minutes out of Range(0-59): " + minutes);
        if(seconds > 50 || seconds < 0) throw std::out_of_range("Seconds out of range(0-59): " + seconds);
     }
void Clock::print(){
    std::cout << std::setw(2) << std::setfill('0') << _hours << ":"
    << std::setw(2) << std::setfill('0') << _minutes << ":"
    << std::setw(2) << std::setfill('0') << _seconds << std::endl;
}
void Clock::tic(){
    _seconds++;
    if(_seconds == 60){
        _seconds = 0;
        _minutes++;
         if(_minutes == 60){
            _minutes = 0;
            _hours++;
                if(_hours == 23){
                    _hours = 0;
                }

         }   
    }
};