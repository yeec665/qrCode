package hiro;

public class CharacterCapacity {

    private static CharacterCapacity b1(
            CharacterCapacityForLevel ecL,
            CharacterCapacityForLevel ecM,
            CharacterCapacityForLevel ecQ,
            CharacterCapacityForLevel ecH) {
        // 1 0 3 2
        return new CharacterCapacity(ecM, ecL, ecH, ecQ);
    }

    private static CharacterCapacityForLevel b2(int numericMode, int alphanumericMode, int byteMode, int kanjiMode) {
        return new CharacterCapacityForLevel(numericMode, alphanumericMode, byteMode, kanjiMode);
    }


    /**
     * https://www.thonky.com/qr-code-tutorial/character-capacities
     */
    private static final CharacterCapacity[] CAP_LIST = {
            b1( // v1
                    b2(41, 25, 17, 10),
                    b2(34, 20, 14, 8),
                    b2(27, 16, 11, 7),
                    b2(17, 10, 7, 4)
            ),
            b1( // v2
                    b2(77, 47, 32, 20),
                    b2(63, 38, 26, 16),
                    b2(48, 29, 20, 12),
                    b2(34, 20, 14, 8)
            ),
            b1( // v3
                    b2(127, 77, 53, 32),
                    b2(101, 61, 42, 26),
                    b2(77, 47, 32, 20),
                    b2(58, 35, 24, 15)
            ),
            b1( // v4
                    b2(187, 114, 78, 48),
                    b2(149, 90, 62, 38),
                    b2(111, 67, 46, 28),
                    b2(82, 50, 34, 21)
            ),
            b1( // v5
                    b2(255, 154, 106, 65),
                    b2(202, 122, 84, 52),
                    b2(144, 87, 60, 37),
                    b2(106, 64, 44, 27)
            ),
            b1( // v6
                    b2(322, 195, 134, 82),
                    b2(255, 154, 106, 65),
                    b2(178, 108, 74, 45),
                    b2(139, 84, 58, 36)
            ),
            b1( // v7
                    b2(370, 224, 154, 95),
                    b2(293, 178, 122, 75),
                    b2(207, 125, 86, 53),
                    b2(154, 93, 64, 39)
            ),
            b1( // v8
                    b2(461, 279, 192, 118),
                    b2(365, 221, 152, 93),
                    b2(259, 157, 108, 66),
                    b2(202, 122, 84, 52)
            ),
            b1( // v9
                    b2(552, 335, 230, 141),
                    b2(432, 262, 180, 111),
                    b2(312, 189, 130, 80),
                    b2(235, 143, 98, 60)
            ),
            b1( // v10
                    b2(652, 395, 271, 167),
                    b2(513, 311, 213, 131),
                    b2(364, 221, 151, 93),
                    b2(288, 174, 119, 74)
            ),
            b1( // v11
                    b2(772, 468, 321, 198),
                    b2(604, 366, 251, 155),
                    b2(427, 259, 177, 109),
                    b2(331, 200, 137, 85)
            ),
            b1( // v12
                    b2(883, 535, 367, 226),
                    b2(691, 419, 287, 177),
                    b2(489, 296, 203, 125),
                    b2(374, 227, 155, 96)
            ),
            b1( // v13
                    b2(1022, 619, 425, 262),
                    b2(796, 483, 331, 204),
                    b2(580, 352, 241, 149),
                    b2(427, 259, 177, 109)
            ),
            b1( // v14
                    b2(1101, 667, 458, 282),
                    b2(871, 528, 362, 223),
                    b2(621, 376, 258, 159),
                    b2(468, 283, 194, 120)
            ),
            b1( // v15
                    b2(1250, 758, 520, 320),
                    b2(991, 600, 412, 254),
                    b2(703, 426, 292, 180),
                    b2(530, 321, 220, 136)
            ),
            b1( // v16
                    b2(1408, 854, 586, 361),
                    b2(1082, 656, 450, 277),
                    b2(775, 470, 322, 198),
                    b2(602, 365, 250, 154)
            ),
            b1( // v17
                    b2(1548, 938, 644, 397),
                    b2(1212, 734, 504, 310),
                    b2(876, 531, 364, 224),
                    b2(674, 408, 280, 173)
            ),
            b1( // v18
                    b2(1725, 1046, 718, 442),
                    b2(1346, 816, 560, 345),
                    b2(948, 574, 394, 243),
                    b2(746, 452, 310, 191)
            ),
            b1( // v19
                    b2(1903, 1153, 792, 488),
                    b2(1500, 909, 624, 384),
                    b2(1063, 644, 442, 272),
                    b2(813, 493, 338, 208)
            ),
            b1( // v20
                    b2(2061, 1249, 858, 528),
                    b2(1600, 970, 666, 410),
                    b2(1159, 702, 482, 297),
                    b2(919, 557, 382, 235)
            ),
            b1( // v21
                    b2(2232, 1352, 929, 572),
                    b2(1708, 1035, 711, 438),
                    b2(1224, 742, 509, 314),
                    b2(969, 587, 403, 248)
            ),
            b1( // v22
                    b2(2409, 1460, 1003, 618),
                    b2(1872, 1134, 779, 480),
                    b2(1358, 823, 565, 348),
                    b2(1056, 640, 439, 270)
            ),
            b1( // v23
                    b2(2620, 1588, 1091, 672),
                    b2(2059, 1248, 857, 528),
                    b2(1468, 890, 611, 376),
                    b2(1108, 672, 461, 284)
            ),
            b1( // v24
                    b2(2812, 1704, 1171, 721),
                    b2(2188, 1326, 911, 561),
                    b2(1588, 963, 661, 407),
                    b2(1228, 744, 511, 315)
            ),
            b1( // v25
                    b2(3057, 1853, 1273, 784),
                    b2(2395, 1451, 997, 614),
                    b2(1718, 1041, 715, 440),
                    b2(1286, 779, 535, 330)
            ),
            b1( // v26
                    b2(3283, 1990, 1367, 842),
                    b2(2544, 1542, 1059, 652),
                    b2(1804, 1094, 751, 462),
                    b2(1425, 864, 593, 365)
            ),
            b1( // v27
                    b2(3517, 2132, 1465, 902),
                    b2(2701, 1637, 1125, 692),
                    b2(1933, 1172, 805, 496),
                    b2(1501, 910, 625, 385)
            ),
            b1( // v28
                    b2(3669, 2223, 1528, 940),
                    b2(2857, 1732, 1190, 732),
                    b2(2085, 1263, 868, 534),
                    b2(1581, 958, 658, 405)
            ),
            b1( // v29
                    b2(3909, 2369, 1628, 1002),
                    b2(3035, 1839, 1264, 778),
                    b2(2181, 1322, 908, 559),
                    b2(1677, 1016, 698, 430)
            ),
            b1( // v30
                    b2(4158, 2520, 1732, 1066),
                    b2(3289, 1994, 1370, 843),
                    b2(2358, 1429, 982, 604),
                    b2(1782, 1080, 742, 457)
            ),
            b1( // v31
                    b2(4417, 2677, 1840, 1132),
                    b2(3486, 2113, 1452, 894),
                    b2(2473, 1499, 1030, 634),
                    b2(1897, 1150, 790, 486)
            ),
            b1( // v32
                    b2(4686, 2840, 1952, 1201),
                    b2(3693, 2238, 1538, 947),
                    b2(2670, 1618, 1112, 684),
                    b2(2022, 1226, 842, 518)
            ),
            b1( // v33
                    b2(4965, 3009, 2068, 1273),
                    b2(3909, 2369, 1628, 1002),
                    b2(2805, 1700, 1168, 719),
                    b2(2157, 1307, 898, 553)
            ),
            b1( // v34
                    b2(5253, 3183, 2188, 1347),
                    b2(4134, 2506, 1722, 1060),
                    b2(2949, 1787, 1228, 756),
                    b2(2301, 1394, 958, 590)
            ),
            b1( // v35
                    b2(5529, 3351, 2303, 1417),
                    b2(4343, 2632, 1809, 1113),
                    b2(3081, 1867, 1283, 790),
                    b2(2361, 1431, 983, 605)
            ),
            b1( // v36
                    b2(5836, 3537, 2431, 1496),
                    b2(4588, 2780, 1911, 1176),
                    b2(3244, 1966, 1351, 832),
                    b2(2524, 1530, 1051, 647)
            ),
            b1( // v37
                    b2(6153, 3729, 2563, 1577),
                    b2(4775, 2894, 1989, 1224),
                    b2(3417, 2071, 1423, 876),
                    b2(2625, 1591, 1093, 673)
            ),
            b1( // v38
                    b2(6479, 3927, 2699, 1661),
                    b2(5039, 3054, 2099, 1292),
                    b2(3599, 2181, 1499, 923),
                    b2(2735, 1658, 1139, 701)
            ),
            b1( // v39
                    b2(6743, 4087, 2809, 1729),
                    b2(5313, 3220, 2213, 1362),
                    b2(3791, 2298, 1579, 972),
                    b2(2927, 1774, 1219, 750)
            ),
            b1( // v40
                    b2(7089, 4296, 2953, 1817),
                    b2(5596, 3391, 2331, 1435),
                    b2(3993, 2420, 1663, 1024),
                    b2(3057, 1852, 1273, 784)
            )
    };

    public static int decideVersionFromList(int len, int mode, int ecLevel) {
        mode &= 0x3;
        ecLevel &= 0x3;
        for (int i = 0; i < CAP_LIST.length; i++) {
            if (CAP_LIST[i].levels[ecLevel].modes[mode] >= len) {
                return i + 1;
            }
        }
        return -1;
    }

    public final CharacterCapacityForLevel[] levels;

    private CharacterCapacity(
            CharacterCapacityForLevel lv0,
            CharacterCapacityForLevel lv1,
            CharacterCapacityForLevel lv2,
            CharacterCapacityForLevel lv3) {
        levels = new CharacterCapacityForLevel[]{lv0, lv1, lv2, lv3};
    }

}