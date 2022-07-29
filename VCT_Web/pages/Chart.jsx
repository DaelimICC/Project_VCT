import CoinChart from '../components/CoinChart';
import Nav from '../components/layout/nav';
import CoinListBox from '../components/common/CoinListBox';
import CoinList from '../components/CoinList';

const Chart = () => {
  return (
    <>
      <Nav title="차트" />
      <div className="">
        {/* <CoinListBox /> */}
        <CoinList />
      </div>
      <div className="border border-black px-[20px]">
        <CoinChart />
      </div>
    </>
  );
};

export default Chart;
