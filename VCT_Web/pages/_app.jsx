import '../styles/globals.css';
import Head from 'next/head';
import Layout from '../components/layout';
import 'tailwindcss/tailwind.css';
import { socket, SocketContext } from '../src/service/socket';
import { useEffect, useState } from 'react';
import { SOCKET_EVENT } from '../src/service/socket';
function MyApp({ Component, pageProps }) {
  // const [coinData, setCoinData] = useState();
  // useEffect(() => {
  //   // App컴포넌트가 마운트 될 때
  //   socket.emit(SOCKET_EVENT.ACCESS_PAGE, { coinData });
  //   // console.log(coinData);

  //   // App컴포넌트가 언마운트 될 때
  //   return () => {
  //     socket.disconnect();
  //   };
  // }, [coinData]);
  return (
    <>
      <Head>
        <title>Project VCT</title>
        <link rel="icon" href="/asset/image/vctLogo.png" />
      </Head>
      <style jsx global>
        {`
          theme {
            extend: {
              colors: {
              }
            }
          }
          h1 {
            font-size: 30px;
          }
          h2 {
            font-size: 20px;
          }
          h3 {
            font-size: 15px;
          }
          h4 {
            font-size: 12px;
          }
          h5 {
            font-size: 10px;
          }
        `}
      </style>
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </>
  );
}

export default MyApp;
