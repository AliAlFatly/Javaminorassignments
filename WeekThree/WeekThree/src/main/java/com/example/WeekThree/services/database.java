package com.example.WeekThree.services;

import java.util.*;
import java.util.stream.Collectors;

import com.example.WeekThree.models.*;

public class database {
    private ArrayList<users> usersTable;
    private ArrayList<account> accountsTable;

    public database(){
        usersTable = this.generateUsers(30);
        accountsTable = this.generateAccounts(15, usersTable);

    }

    public ArrayList<users> getUsersTable(){ return usersTable; }

    public ArrayList<account> getAccountsTable(){ return accountsTable; }

    //create account
    public String createAccount(Integer id){
        ArrayList<Integer> tempUsers = new ArrayList<>(Arrays.asList(id));
        account temp = new account(generateAccountId(), generateRandomIBAN(), 0, tempUsers);
        accountsTable.add(temp);
        return "Account for the user: " + id + " has been created succesfuly";
    }


    public ArrayList<account> getUsersAccounts(int id){
        ArrayList<account> tempAccounts = new ArrayList<>();
        for (int i = 0; i < accountsTable.size(); i++){
            if (accountsTable.get(i).containsUser(id)){
                tempAccounts.add(accountsTable.get(i));
            }
        }
        return tempAccounts;
    }

    public String addUserToAccount(int accountId, int userId){
        if (!userExists(userId)){
            return "User: " + userId + " doesnt exist";
        }

        for (int i = 0; i < accountsTable.size(); i++){
            if (accountsTable.get(i).getId() == accountId){
               return accountsTable.get(i).addUser(userId);
            }
        }
        return "Account: " + accountId + " doesnt exist";
    }

    public String deleteUserFromAccount(int accountId, int userId){
        for (int i = 0; i < accountsTable.size(); i++){
            if (accountsTable.get(i).getId() == accountId){
                return accountsTable.get(i).deleteUser(userId);
            }
        }
        return "Account: " + accountId + " doesnt exist";
    }

    public String deleteAccount(int id){
        for (int i = 0; i < accountsTable.size(); i++){
            if (accountsTable.get(i).getId() == id){
                accountsTable.remove(i);
                return "Account: " + id + " has been deleted";
            }
        }
        return "Account: " + id + " doesnt exit";
    }

    public String blockAccount(int id){
        for (int i = 0; i < accountsTable.size(); i++){
            if (accountsTable.get(i).getId() == id){
                if (accountsTable.get(i).isBlocked()){
                    return "Account: " + id +" is already blocked";
                }

                accountsTable.get(i).blockAccount();
                return "Account: " + id + " has been blocked";
            }
        }
        return "Account: " + id + " doesnt exit";
    }

    private int generateAccountId(){
        int id = 0;
        if(accountsTable != null){
            for (int i = 0; i < accountsTable.size(); i++){
                id = (id >= accountsTable.get(i).getId()) ? id : i;
            }
            return id + 1;
        }
        return id;
    }

    public boolean userExists(int userId){
        for (int i = 0; i < usersTable.size();i++){
            if (usersTable.get(i).getUserId() == userId){
                return true;
            }
        }
        return false;
    }
    //-----------------------------------------------    RANDOM GENERATORS TO CREATE DUMMY DATA - NOT PART OF THE ASSIGNMENT    -----------------------------------------------//

    private static ArrayList<users> generateUsers(int amount){
        ArrayList<users> temp = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            temp.add(new users(i, generateRandomName()));
        }
        return temp;
    }

    private static ArrayList<account> generateAccounts(int amount, ArrayList<users> usersTable){
        ArrayList<account> temp = new ArrayList<>();
        for (int i = 0; i < amount ; i++){
            temp.add(new account(
                    i,
                    generateRandomIBAN(),
                    generateRandomSaldo(10, 5000),
                    genereaterRandomUsersIdList(usersTable)
            ));
        }
        return temp;
    }

    private static float generateRandomSaldo(float min, float max){
        Random rn = new Random();
        return (max - min) * rn.nextFloat() + min;
    }

//    private static List<Integer> genereaterRandomUsersIdList(ArrayList<users> usersTable){
//        List<Integer> tempUserList = new ArrayList<>();
//        Random rn = new Random();
//        int loopBound = Math.min(rn.nextInt(6), rn.nextInt(usersTable.size())); //(rn.nextInt(usersTable.size()) > rn.nextInt(6)) ? 5 : rn.nextInt(usersTable.size());
//        for (int j = 0; j < loopBound; j++){
//            tempUserList.add(usersTable.get(j).getUserId());
//        }
//        return tempUserList;
//    }

    private static ArrayList<Integer> genereaterRandomUsersIdList(ArrayList<users> usersTable){
        List<users> tempUserList = usersTable;
        Collections.shuffle(tempUserList);
        Random rn = new Random();
        tempUserList = tempUserList.stream().limit(rn.nextInt(6)).collect(Collectors.toList());
        ArrayList<Integer> re = new ArrayList<>();

        for (int j = 0; j < tempUserList.size(); j++){
            re.add(tempUserList.get(j).getUserId());
        }
        return re;
    }

    private static String generateRandomName(){
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Levi", "Marco", "Eren", "Mikasa", "Armin", "Annie", "Reiner", "Erwin", "Bertholdt", "Connie", "Sasha", "Erwin", "Hange"));
        ArrayList<String> surnames = new ArrayList<>(Arrays.asList("Akkerman", "Yeager", "Kruger", "Springer", "Lenz", "Leonhart", "Braun", "Hoover", "Smith"));
        Random rn = new Random();
        String name = names.get(rn.nextInt(names.size())) + " " + surnames.get(rn.nextInt(surnames.size()));
        return name;
    }

    private static String generateRandomIBAN(){
        ArrayList<String> banksSignature = new ArrayList<>(Arrays.asList("NL91 INGB 0", "NL91 ABNA 0", "NL91 RABO 0"));
        Random rn = new Random();
        String IBAN = "" + banksSignature.get(rn.nextInt(banksSignature.size())) + recNumber(3) + " " + recNumber(4) + " " + recNumber(2);
        return IBAN;
    }

    private static String recNumber(int digits){
        Random rn = new Random();
        if (digits <= 0){
            return "";
        }
        return rn.nextInt(10) + recNumber(digits - 1);
    }
}
