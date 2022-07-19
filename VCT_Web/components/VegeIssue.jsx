import testAPI from '../pages/api/testAPI';
import Image from 'next/image';

const VegeIssue = () => {
  return (
    <div className="bg-white w-full h-full pb-[20px]">
      <div className="text-[18px] border-b border-gray-400 p-[20px]">
        야채 이슈
      </div>
      {testAPI.map((v, i) => {
        return (
          <div
            className="flex w-full justify-between px-[20px] pt-[20px]"
            key={i}
          >
            <Image
              className="rounded-lg cursor-pointer"
              src={v.image_url}
              alt={v.image_alt}
              width={80}
              height={80}
              layout="fixed"
              onClick={() => window.open(`${v.url}`)}
            />
            <div className="flex flex-col w-[370px]">
              <div className="flex">
                <Image src={v.media_url} alt="미디어" width={18} height={18} />
                <p className="text-[12px] text-gray-400 ml-[5px]">{v.media}</p>
              </div>
              <p
                className="text-[15px] font-bold truncate cursor-pointer"
                onClick={() => window.open(`${v.url}`)}
              >
                {v.title}
              </p>
              <p
                className="text-[10px] text-gray-400 leading-3 cursor-pointer"
                onClick={() => window.open(`${v.url}`)}
              >
                {v.summary > 100 ? v.summary : v.summary.slice(0, 100) + '...'}
              </p>
              <p className="text-[8px] text-gray-400">{v.date}</p>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default VegeIssue;
