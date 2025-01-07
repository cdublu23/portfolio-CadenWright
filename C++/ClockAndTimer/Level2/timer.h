#include "clock.h"

class Timer : public Clock{
    public:
    Timer(int hours, int minutes, int seconds);

    virtual ~Timer() {}
    void tic();
};