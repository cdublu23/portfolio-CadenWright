#include "purse.h"

std::ostream& operator<<(std::ostream& ost, const Purse& purse){
    std::string poundSymbol = "£";
    ost << poundSymbol << purse._pounds << " " << purse._shillings << 's' << purse._pence << 'd';
    return ost;;
}
std::istream& operator >>(std::istream& ist, Purse& purse){
    char pound, s, d;
    int pounds, shillings, pence;
    ist >> pound;
    if(pound != '#'){
        std::cerr<<"Invalid Usage(#pounds shillings pence)"<<std::endl;
    }
    ist >> pounds >> shillings >> s >> pence >> d;
    purse._pounds = pounds;
    purse._shillings = shillings;
    purse._pence = pence;

    purse.rationalize();
    return ist;
}
Purse& Purse::operator++(){
    ++_pence;
    rationalize();

    return *this;
}
Purse Purse::operator++(int){
    Purse purse{*this};
    ++(*this);
    return purse;
}
Purse Purse::operator+(const Purse& purse){
    Purse new_purse(_pounds + purse._pounds, _shillings + purse._shillings, _pence + purse._pence); //Creates new purse object called new_purse
    new_purse.rationalize();
    return new_purse;
}
Purse Purse::operator-(const Purse& purse){
    int new_pence = _pence - purse._pence;
    int new_shillings = _shillings - purse._shillings;
    int new_pounds = _pounds - purse._pounds;

    if(new_pence < 0){
        new_pence += 12;
        new_shillings -= 1;
    }
    if(new_shillings < 0){
        new_shillings += 20;
        new_pounds -= 1;
    }
    Purse new_purse = Purse(new_pounds, new_shillings, new_pence);

    new_purse.rationalize();
    return new_purse;
}
Purse& Purse::operator+=(const Purse& purse){
    _pounds += purse._pounds;
    _shillings += purse._shillings;
    _pence += purse._pence;
    
    rationalize();
    return *this;
}
Purse& Purse::operator-=(const Purse& purse){
    _pounds -= purse._pounds;
    _shillings -= purse._shillings;
    _pence -= purse._pence;

    if(_pence < 0){
        _pence += 12;
        _shillings -= 1;
    }
    if(_shillings < 0){
        _shillings += 20;
        _pounds -= 1;
    }

    rationalize();
    return *this;
}
void Purse::rationalize(){
    if(_pence >= 12){
        _shillings += _pence / 12;
        _pence = _pence % 12;
    }
    else if(_pence < 0){
        int temp = (-_pence +11)/12;
        _shillings -= temp;
        _pence += temp * 12;
    }

    if(_shillings >= 20){
        _pounds += _shillings / 20;
        _shillings = _shillings % 20;
    }
    else if(_pence < 0){
        int temp = (-_shillings +19)/20;
        _pounds -= temp;
        _shillings += temp * 20;
    }

    if(_pounds < 0 && _shillings == 0 && _pence == 0){
        _pounds = 0;
    }

}

