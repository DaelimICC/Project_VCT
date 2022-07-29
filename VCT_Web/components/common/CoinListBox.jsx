import { Fragment, useState } from 'react';
import { Listbox, Transition } from '@headlessui/react';
import { CheckIcon, SelectorIcon } from '@heroicons/react/solid';
import CoinData from '../../pages/api/getData.json';

function CoinListBox(props) {
  const [selected, setSelected] = useState(CoinData[0]);
  const setData = (selected) => {
    props.setValue(selected);
  };

  return (
    <div className="flex flex-col mb-1">
      <div className="flex w-[100px] z-10">
        <Listbox value={selected} onChange={setSelected}>
          <div className="relative w-[100px]">
            <Listbox.Button className="border relative w-full cursor-default rounded-lg bg-white py-2 pl-3 pr-10 text-left shadow-md focus:outline-none focus-visible:border-indigo-500 focus-visible:ring-2 focus-visible:ring-white focus-visible:ring-opacity-75 focus-visible:ring-offset-2 focus-visible:ring-offset-orange-300 sm:text-sm">
              <h3 className="block truncate">{selected.coinName}</h3>
              <span className="pointer-events-none absolute inset-y-0 right-0 flex items-center pr-2">
                <SelectorIcon
                  className="h-5 w-5 text-gray-400"
                  aria-hidden="true"
                />
              </span>
            </Listbox.Button>
            <Transition
              as={Fragment}
              leave="transition ease-in duration-100"
              leaveFrom="opacity-100"
              leaveTo="opacity-0"
            >
              <Listbox.Options className="absolute mt-1 max-h-60 w-full overflow-auto rounded-md bg-white py-1 text-base shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none sm:text-sm z-10">
                {CoinData.map((coin, coinIdx) => (
                  <Listbox.Option
                    key={coinIdx}
                    className={({ active }) =>
                      `relative cursor-default select-none py-2 pl-10 pr-4 ${
                        active ? 'bg-amber-100 text-amber-900' : 'text-gray-900'
                      }`
                    }
                    onClick={() => {
                      setData(coin);
                    }}
                    value={coin}
                  >
                    {({ selected }) => (
                      <>
                        <span
                          className={`block truncate ${
                            selected ? 'font-medium' : 'font-normal'
                          }`}
                        >
                          {coin.coinName}
                        </span>
                        {selected ? (
                          <span className="absolute inset-y-0 left-0 flex items-center pl-3 text-amber-600">
                            <CheckIcon className="h-5 w-5" aria-hidden="true" />
                          </span>
                        ) : null}
                      </>
                    )}
                  </Listbox.Option>
                ))}
              </Listbox.Options>
            </Transition>
          </div>
        </Listbox>
      </div>
      {/* <div className="flex flex-col">
        <h2>{selected.currentPrice}원</h2>
        <h3
          className={`${selected.range > 0 ? 'text-red-600' : 'text-blue-600'}`}
        >
          {selected.range}%
        </h3>
      </div> */}
    </div>
  );
}

export default CoinListBox;
