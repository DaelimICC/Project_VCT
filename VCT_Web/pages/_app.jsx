import '../styles/globals.css';
import Head from 'next/head';
import Layout from '../components/layout';
import 'tailwindcss/tailwind.css';
import Header from '../components/layout/header';

function MyApp({ Component, pageProps }) {
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
