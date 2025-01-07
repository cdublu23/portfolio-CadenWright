#include <iostream>
#include "purse.h"
#include <map>
#include <string>


int main(int argc, char* argv[]){
    std::map<std::string,Purse>vault;
    int accounts;
    std::cout << "How many Accounts would you like to open? ";
    std::cin>>accounts;
    for(int i = 0; i < accounts; i++){
        std::string account_name;
        int pounds, shillings, pence;
        
        std::cout << "Name of Account " << i+1 << ": ";
        std::cin.ignore(); //Without this it will skip if there is a new line character waiting
        std::getline(std::cin, account_name);

        std::cout << "Initial Deposit for Account " << i+1 << "(Pounds Shillings Pence): " << std::endl;
        std::cin >> pounds >> shillings >> pence;

        Purse current = Purse(pounds, shillings, pence);
        vault[account_name] = current;
    }
    Purse total = 0; //type purse so we can use overridden method

    for(auto account: vault){
        std::cout << account.first << ": " << account.second << std::endl;
        total += account.second;
    }
    std::cout << "All Accounts Total: " << total << std::endl;
    
}