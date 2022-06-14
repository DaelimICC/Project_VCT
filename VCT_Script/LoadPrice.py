from urllib.parse import urlencode, unquote

import pymongo
import requests
from pymongo import MongoClient
import xmltodict
from pprint import pprint

client = MongoClient("mongodb://localhost:27017")
vct_db = client['VCT']
vct_col = vct_db['VegetableAPI_vegetableprice']

url = "http://www.garak.co.kr/publicdata/dataOpen.do"

vegetableList = ['오이', '감자', '고구마', '배추', '마늘']

for value in vegetableList:
    queryString = "?" + urlencode(
        {
            "dataid": "data4",
            "pagesize": 1,
            "pageidx": 1,
            "portal.templet": False,
            "id": 3202,
            "passwd": "4664jj1004!",
            "p_ymd": "20220528",
            "p_jymd": "20220527",
            "p_jjymd": "20210530",
            "d_cd": 2,
            "p_pos_gubun": 1,
            "pum_nm": value
        }
    )
    queryURL = url + queryString
    print(queryURL)
    response = requests.get(queryURL)
    print("=== response json data start ===")
    print(response.text)
    print("=== response json data end ===")
    print()

    result = xmltodict.parse(response.text)
    pprint(result)

    vegetable_name = result['lists']['list']['PUM_NM_A']
    vegetable_price = result['lists']['list']['AV_P_A']
    vegetable_unit = result['lists']['list']['U_NAME']

    print(vegetable_price)
    print(vegetable_name)
    print(vegetable_unit)

    data = vct_col.insert_one({
        "vegetable_name": vegetable_name,
        "vegetable_price": vegetable_price,
        "vegetable_unit": vegetable_unit
    })

