import testAPI from '../pages/api/testAPI';
import Image from 'next/image';

const VegeIssue = () => {
  console.log(testAPI[0].image_url);

  return (
    <div className="bg-white h-full">
      <div className="text-[18px] border-b border-gray-400 p-[20px]">
        야채 이슈
      </div>
      <div className="flex border border-black p-[20px]">
        <div>
          <Image
            src={testAPI[0].image_url}
            alt={testAPI[0].image_alt}
            width={80}
            height={80}
            className="rounded-lg"
          />
        </div>
        <div>
          <div className="flex">
            <Image
              src={testAPI[0].media_url}
              alt="미디어"
              width={12}
              height={12}
            />
            <p>{testAPI[0].media}</p>
          </div>
          <div>{testAPI[0].title}</div>
        </div>
      </div>
    </div>
  );
};

export default VegeIssue;
