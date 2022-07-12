import {
  HomeIcon,
  StarIcon,
  CurrencyDollarIcon,
  ChartBarIcon,
  UserIcon,
} from '@heroicons/react/outline';

const Footer = () => {
  return (
    <div className="flex justify-around w-[500px] h-[65px] fixed bottom-0 z-10 border-t border-gray-400">
      <div className="flex flex-col justify-center items-center">
        <HomeIcon className="w-5 h-5" />
        <p className="mt-[2px] text-[12px]">홈</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <StarIcon className="w-5 h-5" />
        <p className="mt-[2px] text-[12px]">관심종목</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <CurrencyDollarIcon className="w-5 h-5" />
        <p className="mt-[2px] text-[12px]">주문</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <ChartBarIcon className="w-5 h-5" />
        <p className="mt-[2px] text-[12px]">차트</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <UserIcon className="w-5 h-5" />
        <p className="mt-[2px] text-[12px]">마이페이지</p>
      </div>
    </div>
  );
};

export default Footer;
