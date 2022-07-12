import { SearchIcon } from '@heroicons/react/solid';

const Header = () => {
  return (
    <>
      <div className="flex w-full h-[60px] px-[20px] justify-between">
        <h1 className="my-auto text-[30px]">VCT</h1>
        <SearchIcon className="w-[30px] h-[30px] my-auto" />
      </div>
    </>
  );
};

export default Header;
