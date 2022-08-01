import CoinChart from '../components/CoinChart';
import Nav from '../components/layout/nav';
import CoinListBox from '../components/common/CoinListBox';
import CoinList from '../components/CoinList';

const Chart = () => {
  return (
    <div className="bg-white">
      <Nav title="차트" />
      <CoinList />
      <div className="border border-black px-[20px]">
        <CoinChart />
      </div>
    </div>
  );
};

export default Chart;
