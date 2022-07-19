import { useEffect, useState } from 'react';

const Nav = ({ title, defaultType }) => {
  const [currentType, setCurrentType] = useState(defaultType);
  return (
    <div
      className={`flex w-[500px] h-[45px] px-[20px] border-b border-gray-400 fixed top-[60px] bg-white ${
        typeof title === 'object' && 'cursor-pointer'
      } z-10`}
    >
      {typeof title === 'string' ? (
        <p className="flex items-center text-[15px] h-full border-b-2 border-orange-500">
          {title}
        </p>
      ) : (
        title.map((v, i) => {
          return (
            <p
              className={`flex items-center text-[15px] mr-[20px] h-full ${
                v.type === currentType && 'border-b-2 border-orange-500'
              }`}
              key={i}
              type={v.type}
              onClick={() => {
                setCurrentType(v.type);
              }}
            >
              {v.title}
            </p>
          );
        })
      )}
      {}
    </div>
  );
};

export default Nav;
