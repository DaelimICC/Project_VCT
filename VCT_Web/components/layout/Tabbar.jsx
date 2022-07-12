import {
  HomeIcon,
  StarIcon,
  CurrencyDollarIcon,
  ChartBarIcon,
  UserIcon,
} from '@heroicons/react/outline';
import Link from 'next/link';

const Footer = () => {
  return (
    <div className="flex justify-around w-[500px] h-[65px] fixed bottom-0 z-10 border-t border-gray-400 bg-white">
      <Link href="/">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <HomeIcon className="w-5 h-5" />
          <p className="mt-[2px] text-[12px]">홈</p>
        </a>
      </Link>
      <Link href="/Interests">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <StarIcon className="w-5 h-5" />
          <p className="mt-[2px] text-[12px]">관심종목</p>
        </a>
      </Link>
      <Link href="/Order">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <CurrencyDollarIcon className="w-5 h-5" />
          <p className="mt-[2px] text-[12px]">주문</p>
        </a>
      </Link>
      <Link href="/Chart">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <ChartBarIcon className="w-5 h-5" />
          <p className="mt-[2px] text-[12px]">차트</p>
        </a>
      </Link>
      <Link href="/Mypage">
        <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
          <UserIcon className="w-5 h-5" />
          <p className="mt-[2px] text-[12px]">마이페이지</p>
        </a>
      </Link>
    </div>
  );
};

export default Footer;
