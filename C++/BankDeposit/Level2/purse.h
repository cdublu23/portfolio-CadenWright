#ifndef PURSE_H
#define PURSE_H
#include <iostream>

class Purse{
    private:
        int _pounds;
        int _shillings;
        int _pence;

        void rationalize();

    public:
        Purse(int pounds = 0, int shillings = 0, int pence = 0)
        : _pounds{pounds}, _shillings{shillings}, _pence{pence}{
            rationalize();
        }
        
        friend std::ostream& operator<<(std::ostream& ost, const Purse& purse);
        friend std::istream& operator >>(std::istream& ist, Purse& purse);
        auto operator<=>(const Purse&) const = default;

        Purse& operator++();
        Purse operator++(int);
        Purse operator+(const Purse& purse);
        Purse operator-(const Purse& purse);
        Purse& operator+=(const Purse& purse);
        Purse& operator-=(const Purse& purse);
};
#endif