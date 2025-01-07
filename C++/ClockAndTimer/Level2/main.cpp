#include "timer.h"
#include "iostream"

int main(int argc, char* argv[]){
    if(argc != 4){
        std::runtime_error("Usage: clock <hour> <minutes> <seconds>");
        return -1;
    }
    try{
        int _hour = std::stoi(argv[1]);
        int _minutes = std::stoi(argv[2]);
        int _seconds = std::stoi(argv[3]);

        Timer new_timer(_hour, _minutes, _seconds);


        std::string in;
        std::cout << "Press 'q' to exit. " << std::endl;
        while(true){ //will loop until told to stop

        std::getline(std::cin, in);
        if(in == "q"){
            return 0;
        }
        new_timer.print();
        new_timer.tic();
        }

    }catch(std::out_of_range e){
        std::cerr << e.what();
        return -2;
    }catch(std::runtime_error x){
        std::cout << x.what();
    }


}

