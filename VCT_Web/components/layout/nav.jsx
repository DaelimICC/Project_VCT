import { useEffect, useState } from 'react';

const Nav = (props) => {
  const { title, defaultType, setValue } = props;
  const [currentType, setCurrentType] = useState(defaultType);
  const setData = (data) => {
    setCurrentType(data);
    props.setValue(data);
  };
  return (
    <div
      className={`flex w-[500px] h-[45px] px-[20px] border-b border-gray-400 fixed top-[60px] bg-white z-10`}
    >
      {typeof title === 'string' ? (
        <h3 className="flex items-center h-full border-b-2 border-orange-500">
          {title}
        </h3>
      ) : (
        title.map((v, i) => {
          return (
            <h3
              className={`flex items-center mr-[20px] h-full ${
                v.type === currentType && 'border-b-2 border-orange-500'
              } ${typeof title === 'object' && 'cursor-pointer'}`}
              key={i}
              type={v.type}
              onClick={() => {
                setData(v.type);
              }}
            >
              {v.title}
            </h3>
          );
        })
      )}
    </div>
  );
};

export default Nav;
