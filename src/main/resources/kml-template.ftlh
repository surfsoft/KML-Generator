<?xml version="1.0" encoding="UTF-8"?>
<kml xmlns="http://www.opengis.net/kml/2.2">

    <Document>

        <name>${documentTitle}</name>
        <open>1</open>
        <description>${documentDescription}</description>

        <Style id="downArrowIcon">
          <IconStyle>
            <Icon>
              <href>http://maps.google.com/mapfiles/kml/pal4/icon28.png</href>
            </Icon>
          </IconStyle>
        </Style>
        <Style id="globeIcon">
          <IconStyle>
            <Icon>
              <href>http://maps.google.com/mapfiles/kml/pal3/icon19.png</href>
            </Icon>
          </IconStyle>
          <LineStyle>
            <width>2</width>
          </LineStyle>
        </Style>
        <Style id="transPurpleLineGreenPoly">
          <LineStyle>
            <color>7fff00ff</color>
            <width>4</width>
          </LineStyle>
          <PolyStyle>
            <color>7f00ff00</color>
          </PolyStyle>
        </Style>
        <Style id="yellowLineGreenPoly">
          <LineStyle>
            <color>7f00ffff</color>
            <width>4</width>
          </LineStyle>
          <PolyStyle>
            <color>7f00ff00</color>
          </PolyStyle>
        </Style>
        <Style id="thickBlackLine">
          <LineStyle>
            <color>87000000</color>
            <width>10</width>
          </LineStyle>
        </Style>
        <Style id="redLineBluePoly">
          <LineStyle>
            <color>ff0000ff</color>
          </LineStyle>
          <PolyStyle>
            <color>ffff0000</color>
          </PolyStyle>
        </Style>
        <Style id="blueLineRedPoly">
          <LineStyle>
            <color>ffff0000</color>
          </LineStyle>
          <PolyStyle>
            <color>ff0000ff</color>
          </PolyStyle>
        </Style>
        <Style id="transRedPoly">
          <LineStyle>
            <width>1.5</width>
          </LineStyle>
          <PolyStyle>
            <color>7d0000ff</color>
          </PolyStyle>
        </Style>
        <Style id="transBluePoly">
          <LineStyle>
            <width>1.5</width>
          </LineStyle>
          <PolyStyle>
            <color>7dff0000</color>
          </PolyStyle>
        </Style>
        <Style id="transGreenPoly">
          <LineStyle>
            <width>1.5</width>
          </LineStyle>
          <PolyStyle>
            <color>7d00ff00</color>
          </PolyStyle>
        </Style>
        <Style id="transYellowPoly">
          <LineStyle> <width>1.5</width>
          </LineStyle>
          <PolyStyle>
            <color>7d00ffff</color>
          </PolyStyle>
        </Style>

        <#list legs as leg>

            <Folder>
                <name>${leg.title}</name>
                <visibility>0</visibility>
                <description>${leg.description}</description>

                <#list leg.races as race>

                <Placemark>
                    <name>${race.title}</name>
                    <visibility>0</visibility>
                    <description>${race.description}</description>
                    <LookAt>
                        <longitude>${race.longitude}</longitude>
                        <latitude>${race.latitude}</latitude>
                        <altitude>0</altitude>
                        <heading>0</heading>
                        <tilt>0</tilt>
                        <range>1000</range>
                    </LookAt>
                    <LineString>
                        <altitudeMode>absolute</altitudeMode>
                        <extrude>0</extrude>
                        <tessellate>0</tessellate>
                        <coordinates> ${race.coordinates} </coordinates>
                    </LineString>
                </Placemark>

                </#list>

            </Folder>

        </#list>

    </Document>

</kml>
