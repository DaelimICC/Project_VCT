import testAPI from '../pages/api/testAPI';
import Image from 'next/image';

const VegeIssue = () => {
  return (
    <div className="bg-white w-full h-full pb-[20px]">
      <h2 className=" border-b border-gray-400 p-[20px]">야채 이슈</h2>
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
                <h4 className="text-gray-400 ml-[5px]">{v.media}</h4>
              </div>
              <h3
                className="font-bold truncate cursor-pointer"
                onClick={() => window.open(`${v.url}`)}
              >
                {v.title}
              </h3>
              <h5
                className="text-gray-400 leading-3 cursor-pointer"
                onClick={() => window.open(`${v.url}`)}
              >
                {v.summary > 100 ? v.summary : v.summary.slice(0, 100) + '...'}
              </h5>
              <h5 className="text-gray-400">{v.date}</h5>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default VegeIssue;
