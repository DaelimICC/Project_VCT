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
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </>
  );
}

export default MyApp;
