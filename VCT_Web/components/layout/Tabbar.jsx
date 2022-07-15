import {
  HomeIcon,
  StarIcon,
  CurrencyDollarIcon,
  ChartBarIcon,
  UserIcon,
} from '@heroicons/react/outline';
import Link from 'next/link';
import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';

const Footer = () => {
  const router = useRouter();
  const [ActiveComponent, setActiveComponent] = useState('');
  const tabbarList = [
    { id: 0, route: '/', icon: 'HomeIcon', tabbarName: '홈' },
    { id: 1, route: '/Interests', icon: 'StarIcon', tabbarName: '관심종목' },
    { id: 2, route: '/Order', icon: 'CurrentcyDollarIcon', tabbarName: '주문' },
    { id: 3, route: '/Chart', icon: 'ChartBarIcon', tabbarName: '차트' },
    { id: 4, route: '/Mypage', icon: 'UserIcon', tabbarName: '마이페이지' },
  ];
  return (
    <div className="flex justify-around w-[500px] h-[65px] fixed bottom-0 z-10 border-t border-gray-400 bg-white">
      {/* {tabbarList.map((v, i) => {
        console.log(v.icon);
        return (
          <Link href={v.route} key={i}>
            <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
              <HomeIcon
                className={`w-5 h-5 ${
                  router.pathname === `${v.route}` ? 'text-orange-500' : null
                }`}
              />
              <p
                className={`mt-[2px] text-[12px] ${
                  router.pathname === `${v.route}` ? 'text-orange-500' : null
                }`}
              >
                홈
              </p>
            </a>
          </Link>
        );
      })} */}
      <Link href="/">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <HomeIcon
            className={`w-5 h-5 ${
              router.pathname === '/' ? 'text-orange-500' : null
            }`}
          />
          <p
            className={`mt-[2px] text-[12px] ${
              router.pathname === '/' ? 'text-orange-500' : null
            }`}
          >
            홈
          </p>
        </a>
      </Link>
      <Link href="/Interests">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <StarIcon
            className={`w-5 h-5 ${
              router.pathname === '/Interests' ? 'text-orange-500' : null
            }`}
          />
          <p
            className={`mt-[2px] text-[12px] ${
              router.pathname === '/Interests' ? 'text-orange-500' : null
            }`}
          >
            관심종목
          </p>
        </a>
      </Link>
      <Link href="/Order">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <CurrencyDollarIcon
            className={`w-5 h-5 ${
              router.pathname === '/Order' ? 'text-orange-500' : null
            }`}
          />
          <p
            className={`mt-[2px] text-[12px] ${
              router.pathname === '/Order' ? 'text-orange-500' : null
            }`}
          >
            주문
          </p>
        </a>
      </Link>
      <Link href="/Chart">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <ChartBarIcon
            className={`w-5 h-5 ${
              router.pathname === '/Chart' ? 'text-orange-500' : null
            }`}
          />
          <p
            className={`mt-[2px] text-[12px] ${
              router.pathname === '/Chart' ? 'text-orange-500' : null
            }`}
          >
            차트
          </p>
        </a>
      </Link>
      <Link href="/Mypage">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <UserIcon
            className={`w-5 h-5 ${
              router.pathname === '/Mypage' ? 'text-orange-500' : null
            }`}
          />
          <p
            className={`mt-[2px] text-[12px] ${
              router.pathname === '/Mypage' ? 'text-orange-500' : null
            }`}
          >
            마이페이지
          </p>
        </a>
      </Link>
    </div>
  );
};

export default Footer;
