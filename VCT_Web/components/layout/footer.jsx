import {
  HomeIcon,
  StarIcon,
  CurrencyDollarIcon,
  ChartBarIcon,
  UserIcon,
} from '@heroicons/react/solid';

const Footer = () => {
  return (
    <div className="flex justify-around w-[500px] h-[65px] absolute bottom-0 z-10 border border-black">
      <div className="flex flex-col justify-center items-center">
        <HomeIcon className="w-5 h-5" />
        <p className="text-[18px]">홈</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <StarIcon className="w-5 h-5" />
        <p className="text-[18px]">관심종목</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <CurrencyDollarIcon className="w-5 h-5" />
        <p className="text-[18px]">주문</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <ChartBarIcon className="w-5 h-5" />
        <p className="text-[18px]">차트</p>
      </div>
      <div className="flex flex-col justify-center items-center">
        <UserIcon className="w-5 h-5" />
        <p className="text-[18px]">마이페이지</p>
      </div>
    </div>
  );
};

export default Footer;
