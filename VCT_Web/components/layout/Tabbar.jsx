import {
  HomeIcon,
  StarIcon,
  CurrencyDollarIcon,
  ChartBarIcon,
  UserIcon,
} from '@heroicons/react/outline';
import Link from 'next/link';
import { useRouter } from 'next/router';

const Footer = () => {
  const router = useRouter();
  const tabbarList = [
    { id: 0, route: '/', icon: HomeIcon, tabbarName: '홈' },
    { id: 1, route: '/Interests', icon: StarIcon, tabbarName: '관심종목' },
    { id: 2, route: '/Order', icon: CurrencyDollarIcon, tabbarName: '주문' },
    { id: 3, route: '/Chart', icon: ChartBarIcon, tabbarName: '차트' },
    { id: 4, route: '/Mypage', icon: UserIcon, tabbarName: '마이페이지' },
  ];
  return (
    <div className="flex justify-around w-[500px] h-[65px] fixed bottom-0 z-10 border-t border-gray-400 bg-white">
      {tabbarList.map((v, i) => {
        const ActiveComponents = v.icon;
        return (
          <Link href={v.route} key={i}>
            <a className="flex flex-col justify-center items-center hover:text-orange-500 cursor-pointer">
              <ActiveComponents
                className={`w-5 h-5 ${
                  router.pathname === `${v.route}` ? 'text-orange-500' : null
                }`}
              />
              <p
                className={`mt-[2px] text-[12px] ${
                  router.pathname === `${v.route}` ? 'text-orange-500' : null
                }`}
              >
                {v.tabbarName}
              </p>
            </a>
          </Link>
        );
      })}
    </div>
  );
};

export default Footer;
