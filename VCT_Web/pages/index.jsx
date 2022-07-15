import Head from 'next/head';
import Image from 'next/image';
import Header from '../components/layout/header';
import Nav from '../components/layout/nav';
import styles from '../styles/Home.module.css';

export default function Home() {
  const titleList = [
    { id: 0, title: '급상승', type: 'rise' },
    { id: 1, title: '급하락', type: 'fall' },
    { id: 2, title: '거래량', type: 'voulme' },
  ];
  return (
    <>
      <Nav title={titleList} defaultType="rise" />
      <div className="">메인페이지</div>
    </>
  );
}
