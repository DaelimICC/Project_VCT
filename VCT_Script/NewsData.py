from bs4 import BeautifulSoup
import urllib
import requests
import pprint

url = 'https://www.google.com/search?q=%EC%B1%84%EC%86%8C&source=lmns&tbm=nws&bih=746&biw=1536&hl=ko&sa=X&ved=2ahUKEwjc6NvOn4v5AhUGQfUHHaLSBYwQ_AUoAnoECAEQAg'
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}

data = requests.get(url, headers=headers)

soup = BeautifulSoup(data.text, 'html.parser')

title = []
media = []
content = []
hyper = []
for index in range(2, 8):
  datas = soup.select('#rso > div:nth-child(1) > div:nth-child('+ str(index) +') > div > a > div > div.iRPxbe > div.mCBkyc.y355M.ynAwRc.MBeuO.nDgy9d')
  mediaNames = soup.select('#rso > div:nth-child(1) > div:nth-child('+ str(index) +') > div > a > div > div.iRPxbe > div.CEMjEf.NUnG9d > span')
  contents = soup.select('#rso > div:nth-child(1) > div:nth-child('+ str(index) +') > div > a > div > div.iRPxbe > div.GI74Re.nDgy9d')
  hypers = soup.select('#rso > div:nth-child(1) > div:nth-child('+ str(index) +') > div > a')
  
  for data in datas:
    title.append(data.text)
  for mediaName in mediaNames:
    media.append(mediaName.text)
  for cont in contents:
    content.append(cont.text)
  for url in hypers:
    hyper.append(url.attrs['href'])
  

jsons = []
for i in range(len(title)):
  json = {}
  json['title'] = title[i]
  json['media'] = media[i]
  json['summary'] = content[i]
  json['url'] = hyper[i]
  
  
  jsons.append(json)
  
pprint.pprint(jsons)