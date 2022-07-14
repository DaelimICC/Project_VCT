import Head from 'next/head';
import Image from 'next/image';
import Header from '../components/layout/header';
import Nav from '../components/layout/nav';
import styles from '../styles/Home.module.css';

export default function Home() {
  const titleList = ['급상승', '급하락', '거래량'];
  return (
    <>
      {titleList.map((v, i) => {
        console.log(v);
        <Nav title={v} key={i} />;
      })}
      <div className="">메인페이지</div>
    </>
  );
}
