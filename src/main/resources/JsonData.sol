pragma solidity ^0.4.2;

contract JsonData {

    function JsonData(){

    }

    mapping(string=>string) JsonDataMap;

    /* getter */
    function getJsonData(string jsonKey) public constant returns(string data) {
        data = JsonDataMap[jsonKey];
        return data;
    }

    /* setter */
    function setJsonData(string jsonKey, string jsonValue) public returns(bool ret) {
        JsonDataMap[jsonKey] = jsonValue;
        return true;
    }

}
