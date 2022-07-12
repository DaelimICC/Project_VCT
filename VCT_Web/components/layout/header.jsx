import { SearchIcon } from '@heroicons/react/solid';

const Header = () => {
  return (
    <>
      <div className="flex w-[500px] h-[60px] px-[20px] justify-between fixed top-0 bg-white">
        <h1 className="my-auto text-[30px]">VCT</h1>
        <SearchIcon className="w-[30px] h-[30px] my-auto" />
      </div>
    </>
  );
};

export default Header;
