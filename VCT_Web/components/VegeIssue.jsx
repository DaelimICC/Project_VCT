import { useState } from 'react';
import { getHTML } from '../pages/api/getHTML';

// import getHTML from '../pages/api/getHTML';
// const axios = require('axios');
// const cheerio = require('cheerio');
export const getStaticProps = async () => {
  const datas = getHTML();
  return {
    props: {
      datas,
    },
  };
};

const VegeIssue = () => {
  getStaticProps().then((v) => console.log(v));
  //   const [news, setNews] = useState('');
  //   const getHTML = async () => {
  //     try {
  //       return await axios.get(
  //         'https://search.naver.com/search.naver?where=news&ie=utf8&sm=nws_hty&query=%EC%95%BC%EC%B1%84'
  //       );
  //     } catch (error) {
  //       console.error(error);
  //     }
  //   };

  //   getHTML()
  //     .then((html) => {
  //       let ulList = [];
  //       const $ = cheerio.load(html.data);
  //       const bodyList = $('div.group_news ul.list_news li').children(
  //         'li.bx div.news_wrap.api_ani_send'
  //       );

  //       bodyList.each(function (i, elem) {
  //         ulList[i] = {
  //           title: $(this).find('div.news_area a.news_tit').text(),
  //           url: $(this).find('div.news_area a.news_tit').attr('href'),
  //           media: $(this)
  //             .find('div.news_area div.news_info div.info_group a.info.press')
  //             .text(),
  //           media_url: $(this)
  //             .find(
  //               'div.news_area div.news_info div.info_group a.info.press span.thumb_box img.thumb'
  //             )
  //             .attr('src'),
  //           image_url: $(this).find('a.dsc_thumb img.thumb.api_get').attr('src'),
  //           image_alt: $(this).find('a.dsc_thumb img.thumb.api_get').attr('alt'),
  //           summary: $(this)
  //             .find(
  //               'div.news_area div.news_dsc div.dsc_wrap a.api_txt_lines.dsc_txt_wrap'
  //             )
  //             .text(),
  //           // .slice(0, -11),
  //           date: $(this)
  //             .find('div.news_area div.news_info div.info_group span.info')
  //             .text(),
  //         };
  //       });

  //       const data = ulList.filter((n) => n.title);
  //       return data;
  //     })
  //     .then((res) => {
  //       console.log(res);
  //       setNews(res);
  //     });

  // const { vegeNews } = getHTML();
  return (
    <div className="bg-white h-full">
      <div className="text-[18px] border-b border-gray-400 p-[20px]">
        야채 이슈
      </div>
      <div className="border border-black p-[20px]">
        <div></div>
      </div>
    </div>
  );
};

export default VegeIssue;
