package Lab3;

import java.util.HashMap;

/**
 * Этот класс хранит базовое состояние, необходимое алгоритму A* для вычисления пути по карте. 
 * Это состояние включает в себя коллекцию "открытых путевых точек" и другую коллекцию "закрытых путевых точек". 
 * Кроме того, этот класс предоставляет основные операции, 
 * необходимые алгоритму поиска пути A* для выполнения его обработки.
 **/
public class AStarState
{
    /** Это ссылка на карту, по которой перемещается алгоритм A*. **/
    private Map2D map;

    private HashMap<Location, Waypoint> openTop = new HashMap<Location, Waypoint>();
    private HashMap<Location, Waypoint> closeTop = new HashMap<Location, Waypoint>(); //два нестатических поля


    /**
     * Инициализируйте новый объект состояния для использования алгоритма поиска пути A*.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        this.openTop = new HashMap<>();
        this.closeTop = new HashMap<>();
    }

    /** Возвращает карту, по которой перемещается навигатор A*. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * Этот метод сканирует все открытые путевые точки и возвращает путевую точку 
     * с минимальной общей стоимостью. Если открытых путевых точек нет, этот метод возвращает <код>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        if(openTop.isEmpty()) {
            return null;
        }
        Waypoint minOpenWP = (Waypoint) openTop.values().toArray()[0];

        for(Waypoint openWP : openTop.values()) {
            if (openWP.getTotalCost() < minOpenWP.getTotalCost()) {
                minOpenWP = openWP;
            }
        }
        return minOpenWP;
    }

    /**
     * Этот метод добавляет путевую точку в коллекцию "открытые путевые точки" 
     * (или потенциально обновляет уже имеющуюся путевую точку). Если в местоположении новой путевой точки 
     * еще нет открытой путевой точки, то новая путевая точка просто добавляется в коллекцию. 
     * Однако, если в местоположении новой путевой точки уже есть путевая точка, 
     * новая путевая точка заменяет старую <em> только в том случае, если </em> значение "предыдущей стоимости" 
     * новой путевой точки меньше значения "предыдущей стоимости" текущей путевой точки.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Location newLoc = newWP.getLocation();
        if (!this.openTop.containsKey(newLoc)){
            this.openTop.put(newLoc, newWP);
            return true;
        }
        if (this.openTop.get(newLoc).getPreviousCost() > newWP.getPreviousCost()){
            this.openTop.put(newLoc, newWP);
            return true;
        }
        return false;
    }


    /** Возвращает текущее количество открытых путевых точек. **/
    public int numOpenWaypoints()
    {
        return openTop.size();
    }


    /**
     * Этот метод перемещает путевую точку в указанном местоположении из открытого списка в закрытый список.
     **/
    public void closeWaypoint(Location loc)
    {
        openTop.remove(loc); // Удаляем вершину
        closeTop.put(loc, openTop.get(loc));
    }

    /**
     * Возвращает значение true, если коллекция закрытых путевых точек содержит путевую точку
     * для указанного местоположения.
     **/
    public boolean isLocationClosed(Location loc)
    {
        boolean flag = false;
        for (Location location : closeTop.keySet()){
            if (location.equals(loc)){
                flag = true;
            }
        }
        return flag;
    }
}

