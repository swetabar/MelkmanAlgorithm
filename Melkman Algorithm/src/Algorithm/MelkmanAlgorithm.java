package Algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//Considering an anticlockwise ordering of points
public class MelkmanAlgorithm {

	public ArrayList<Point> returnConvexHull(final ArrayList<Point> points) {

		final ArrayList<Point> hull = new ArrayList<Point>();
		final ArrayList<Point> result = new ArrayList<Point>();

		final Deque<Point> hullDq = new ArrayDeque<Point>();
		hull.add(points.get(2));

		if (Point.isLeft(points.get(0), points.get(1), points.get(2)) > 0) {
			hull.add(points.get(0));
			hull.add(points.get(1));
		} else {
			hull.add(points.get(1));
			hull.add(points.get(0));
		}
		hull.add(points.get(2));
		hullDq.addAll(hull);
		for (int i = 3; i < points.size(); i++) {

			Point P1 = hullDq.pollLast();
			Point P0 = hullDq.pollLast();
			hullDq.offerLast(P0);
			hullDq.offerLast(P1);
			Point T0 = hullDq.pollFirst();
			Point T1 = hullDq.pollFirst();
			hullDq.offerFirst(T1);
			hullDq.offerFirst(T0);
			if (Point.isLeft(P0, P1, points.get(i)) > 0
					&& Point.isLeft(T0, T1, points.get(i)) > 0)
				continue;
			while (Point.isLeft(P0, P1, points.get(i)) <= 0) {
				hullDq.pollLast();
				P1 = hullDq.pollLast();
				P0 = hullDq.pollLast();
				hullDq.offerLast(P0);
				hullDq.offerLast(P1);
			}
			hullDq.offerLast(points.get(i));
			T0 = hullDq.pollFirst();
			T1 = hullDq.pollFirst();
			hullDq.offerFirst(T1);
			hullDq.offerFirst(T0);
			while (Point.isLeft(T0, T1, points.get(i)) <= 0) {
				hullDq.pollFirst();
				T0 = hullDq.pollFirst();
				T1 = hullDq.pollFirst();
				hullDq.offerFirst(T1);
				hullDq.offerFirst(T0);
			}
			hullDq.offerFirst(points.get(i));
		}
		final int len = hullDq.size();
		for (int i = 0; i < len; i++)
			result.add(hullDq.poll());

		return result;

	}
}
