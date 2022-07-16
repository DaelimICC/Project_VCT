import { SearchIcon } from '@heroicons/react/solid';
import Link from 'next/link';

const Header = () => {
  return (
    <>
      <div className="flex w-[500px] h-[60px] px-[20px] justify-between fixed top-0 bg-white">
        <Link href="/">
          <h1 className="my-auto text-[30px] hover:cursor-pointer">VCT</h1>
        </Link>
        <SearchIcon className="w-[30px] h-[30px] my-auto cursor-pointer hover:text-orange-500" />
      </div>
    </>
  );
};

export default Header;
