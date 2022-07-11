import '../styles/globals.css';
import Head from 'next/head';
function MyApp({ Component, pageProps }) {
  return (
    <>
      <Head>
        <title>Project VCT</title>
        <link rel="icon" href="/asset/image/vctLogo.png" />
      </Head>
      <Component {...pageProps} />
    </>
  );
}

export default MyApp;
