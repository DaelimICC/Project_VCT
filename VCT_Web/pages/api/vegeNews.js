// const axios = require('axios');
import axios from 'axios';
// import Cheerio from 'cheerio';
const cheerio = require('cheerio');

const vegeNews = async () => {
  try {
    return await axios.get(
      'https://search.naver.com/search.naver?where=news&ie=utf8&sm=nws_hty&query=%EC%95%BC%EC%B1%84'
    );
  } catch (error) {
    console.error(error);
  }
};

vegeNews()
  .then((html) => {
    // console.log(html.data);
    let ulList = [];
    const $ = cheerio.load(html.data);
    // console.log(html.data === true);
    const $bodyList = $('div.group_news ul.list_news li').children(
      'li.bx div.news_wrap.api_ani_send'
    );
    $bodyList.each(function (i, elem) {
      ulList[i] = {
        title: $(this).find('div.news_area a.news_tit').text(),
        url: $(this).find('div.news_area a.news_tit').attr('href'),
        media: $(this)
          .find('div.news_area div.news_info div.info_group a.info.press')
          .text(),
        media_url: $(this)
          .find(
            'div.news_area div.news_info div.info_group a.info.press span.thumb_box img.thumb'
          )
          .attr('src'),
        image_url: $(this).find('a.dsc_thumb img.thumb.api_get').attr('src'),
        image_alt: $(this).find('a.dsc_thumb img.thumb.api_get').attr('alt'),
        summary: $(this)
          .find(
            'div.news_area div.news_dsc div.dsc_wrap a.api_txt_lines.dsc_txt_wrap'
          )
          .text(),
        // .slice(0, -11),
        date: $(this)
          .find('div.news_area div.news_info div.info_group span.info')
          .text(),
      };
    });

    const data = ulList.filter((n) => n.title);
    return data;
  })
  .then((res) => {
    console.log(res);
    res;
  });

export default vegeNews;
