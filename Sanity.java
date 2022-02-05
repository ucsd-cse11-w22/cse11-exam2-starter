// Provided Sanity Tests

import tester.*;

class ProvidedArrayTests {
    ExampleArrays ea = new ExampleArrays();

    void testAverageWithoutLowest(Tester t) {
		Number[] test1 = {new WholeNumber(1) , new Fraction(4, 2), new WholeNumber(3)};
		
        t.checkExpect(ea.averageWithoutLowest(test1).toDouble(), 2.5);
	}

    void testSumPairs(Tester t) {
        Pair[] p1 = {new Pair(1,2), new Pair(3,4), new Pair(5,6)};
        Pair[] p2 = {new Pair(1,2), new Pair(3,6)};

        Pair[] expect_p1_p2 = {new Pair(2, 4), new Pair(6, 10) };
        Pair[] result_p1_p2 = ea.sumPairs(p1, p2);
        
        t.checkExpect(result_p1_p2, expect_p1_p2);
    }

    void testSumPairsEmpty(Tester t) {
        Pair[] p1 = {new Pair(1,2), new Pair(3,4), new Pair(5,6)};
        Pair[] p2 = new Pair[0];

        Pair[] expect_p1_p2 = new Pair[0];
        Pair[] result_p1_p2 = ea.sumPairs(p1, p2);

        t.checkExpect(result_p1_p2, expect_p1_p2);
    }

    void testOnRegionEdge(Tester t) {
        Region[] r1 = {new RectRegion(new Point(0,1), new Point(6,6)), new CircleRegion(new Point(0, 0), 1), new RectRegion( new Point(5,5), new Point(10, 10))};
        
        Region[] expect_r1 = {new RectRegion(new Point(0, 1), new Point(6, 6)), new CircleRegion(new Point(0, 0), 1)};
        Region[] result_r1 = ea.onRegionEdge(r1, new Point(0,1));

        t.checkExpect(result_r1, expect_r1);
    }
}

class ProvidedTweetTests {
    User u1 = new User("greg", "Greg", 12);
    User u2 = new User("greg2", "Greg2", 12);

    Tweet t1 = new TextTweet("We're already halfway through with the quarter", u1, 12);
    Tweet t2 = new ReplyTweet("Yeah, can you believe it. It still feel like the beginning of the quarter", u2, 13, t1);

    void testMostPopularAuthorOnThread(Tester t) {
        t.checkExpect(t2.mostPopularAuthorOnThread(), u2);
    }

    void testShortestTweetOnThread(Tester t) {
        t.checkExpect(t2.shortestTweetOnThread(), t1);
    }
}