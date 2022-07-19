import Head from 'next/head';
import Image from 'next/image';
import Header from '../components/layout/header';
import Nav from '../components/layout/nav';
import VegeIssue from '../components/vegeIssue';
import styles from '../styles/Home.module.css';

export default function Home() {
  const titleList = [
    { id: 0, title: '급상승', type: 'rise' },
    { id: 1, title: '급하락', type: 'fall' },
    { id: 2, title: '거래량', type: 'voulme' },
  ];
  return (
    <div className="pb-[65px]">
      <Nav title={titleList} defaultType="rise" />
      <div className="h-[380px] border-b border-gray-500 bg-white mb-[20px]">
        메인페이지
      </div>
      <VegeIssue />
    </div>
  );
}
