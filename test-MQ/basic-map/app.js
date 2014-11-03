/**
 * Created by jamesRMBP on 02/11/14.
 */
window.onload = function() {
    var map = L.map('map', {
        layers: MQ.mapLayer()
    });

    MQ.geocode().search('san francisco ca')
        .on('success', function(e) {
            var best = e.result.best,
                latlng = best.latlng;

            map.setView(latlng, 12);

            L.marker([ latlng.lat, latlng.lng ])
                .addTo(map)
                .bindPopup('<strong>' + best.adminArea5 + ', ' + best.adminArea3 + '</strong><br />is located here.')
                .openPopup()
        });
};