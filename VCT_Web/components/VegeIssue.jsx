import vegeNews from '../pages/api/vegeNews';

const VegeIssue = () => {
  vegeNews();
  return (
    <div className="bg-white h-full">
      <div className="text-[18px] border-b border-gray-400 p-[20px]">
        야채 이슈
      </div>
      <div className="border border-black p-[20px]">
        <div></div>
      </div>
    </div>
  );
};

export default VegeIssue;
