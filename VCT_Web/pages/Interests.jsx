import CoinList from '../components/CoinList';
import Nav from '../components/layout/nav';

const Interests = () => {
  return (
    <>
      <Nav title="관심종목" />
      <CoinList pageType="Interests" />
    </>
  );
};

export default Interests;
