import CoinChart from '../components/CoinChart';
import Nav from '../components/layout/nav';

const Chart = () => {
  return (
    <>
      <Nav title="차트" />
      <div className="border border-black px-[20px]">
        <CoinChart />
      </div>
    </>
  );
};

export default Chart;
